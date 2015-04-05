package statemachine;

import java.util.HashMap;
import java.util.Map;

public class Runner {
	protected Map<String, Class<State>> states;
	protected Map<String, Object> kvStore;
	protected String initialState;
	
	public <T extends State> Runner(Class<T> initialState) {
		this.initialState = initialState.getName();
		states = new HashMap<String, Class<State>>();
		states.put(initialState.getName(), (Class<State>) initialState);
	}
	
	public <T extends State> void addState(Class<T> s) {
		states.put(s.getName(), (Class<State>) s);
	}
	
	public void Run() throws InstantiationException, IllegalAccessException {
		kvStore = new HashMap<String, Object>();
		String nextState = initialState;
		while (nextState != null) {
			if (!states.containsKey(nextState)) {
				throw new IllegalStateException("Requested state " + nextState + " does not exist");
			}
			State tmp = states.get(nextState).newInstance();
			nextState = tmp.doState(this);
		}
	}
	
	public Object getKV(String k) {
		if (!kvStore.containsKey(k)) {
			return null;
		}
		return kvStore.get(k);
	}
	
	public void setKV(String k, Object v) {
		kvStore.put(k, v);
	}
}

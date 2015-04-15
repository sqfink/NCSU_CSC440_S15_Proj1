package statemachine;

import java.util.HashMap;
import java.util.Map;

public class Runner {
	protected Map<String, Class<State>> states;
	protected Map<String, Object> kvStore;
	protected String initialState;
	
	@SuppressWarnings("unchecked")
	public <T extends State> Runner(Class<T> initialState) {
		this.initialState = initialState.getName();
		states = new HashMap<String, Class<State>>();
		states.put(initialState.getName(), (Class<State>) initialState);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends State> void addState(Class<T> s) {
		states.put(s.getName(), (Class<State>) s);
	}
	
	public void Run() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		kvStore = new HashMap<String, Object>();
		String nextState = initialState;
		String lastState = "_INIT";
		try {
			while (nextState != null) {
				if (!states.containsKey(nextState)) {
					Class<?> c = this.getClass().getClassLoader().loadClass(nextState);
					if (c != null) {
						states.put(nextState, (Class<State>) c);
					} else {
						throw new ClassNotFoundException("Class loader returned null for " + nextState);
					}
				}
				lastState = nextState;
				State tmp = states.get(nextState).newInstance();
				nextState = tmp.doState(this);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("State loader failed.");
			System.out.println("Could not find " + nextState + " (last state " + lastState + ")");
			e.printStackTrace();
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

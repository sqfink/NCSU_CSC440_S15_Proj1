package dialogs.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DialogAttributes {
	String name() default "";
	String prompt();
}

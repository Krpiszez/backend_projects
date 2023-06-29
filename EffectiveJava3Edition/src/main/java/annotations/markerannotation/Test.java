package annotations.markerannotation;

//Marker annotation type declaration - Page 180

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method is a test method. Use only on
 * parameterless static methods.
 */
@Retention(RetentionPolicy.RUNTIME) // çalışma zamanında korunması gerektiğini belirtmektedir
@Target(ElementType.METHOD) // bu notasyonun sadece metotlar üzerinde kullanılabileceğini belirtmektedir. 
public @interface Test {
	
}
package reflection;

import java.lang.reflect.*;

public class TestReflection {
	
	/*
	 * Reflection(Yansıma), Java Sanal Makinesinde(Java Virtual Machine, JVM)
	 *  çalışan uygulamaların, çalışma zamanındaki(runtime) davranışlarını 
	 *  inceleme ve bu davranışlara yön verme imkanı sağlayan bir özelliktir. 
	 *  java.lang.reflect API' sinde tanımlanan yansıma özelliği, hata ayıklama(debugging)
	 *   ve test araçlarında, görsel yazılım geliştirme ortamlarında kullanılmaktadır.
	 */
	
	public static void main(String[] args) {
		
		try
		{
			// Joker tipleri wild- unchecked
			Class<?> aClass = Class.forName("com.effectivejava.tutorial.effectivejava.itema39.reflection.Metallica");
			Object obj = aClass.newInstance();
			//Object obj2 = aClass.getDeclaredConstructor().newInstance();
			// Varargs..
			Constructor<?> cons = aClass.getDeclaredConstructor(String.class, Integer.TYPE);
			
			for (Field field : aClass.getDeclaredFields())
			{
				System.out.println("Field:" + field.getName());
			}
			System.out.println("Part1 Bitti");
			System.out.println();

			
			System.out.println("Modifiers:" + cons.getModifiers());
			int modifier = cons.getModifiers();
			System.out.println("Modifer: " + Modifier.toString(modifier));
			
			
			System.out.println("Name:" + cons.getName());
			System.out.println("IsAccessible:" + cons.isAccessible());
			System.out.println("IsSynthetic:" + cons.isSynthetic()); // varsayılan başka bir kurucu metodu çağırıyor olması
			System.out.println("IsVarArgs:" + cons.isVarArgs());

			System.out.println("Part2 Bitti");
			System.out.println();

			Method setVocalAge = aClass.getMethod("setVocalAge", Integer.TYPE);
			setVocalAge.invoke(obj, 25);

			Method getVocalAge = aClass.getMethod("getVocalAge");
			Object age = getVocalAge.invoke(obj);
			System.out.println("Yaş:" + age);

			Method printIndNumb = aClass.getMethod("kişiSayısınıYazdır");
			// calling static method with null object
			printIndNumb.invoke(null);

			// getting the all methods include private with declared methods
			Method increaseAge = aClass.getDeclaredMethod("yaşıArtır");
			// accessing to a private method
			increaseAge.setAccessible(true);
			increaseAge.invoke(obj);

			Method toString = aClass.getMethod("toString");
			Object data = toString.invoke(obj);
			System.out.println("Person:" + data);

		} catch (ClassNotFoundException e) {
			System.err.print("The class not found: ");
			System.err.println(e.getMessage());
		} catch (InstantiationException e) {
			System.err.print("The object can not be instantiated from the class: ");
			System.err.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.print("illegal access to method");
			System.err.println(e.getMessage());
		} catch (NoSuchMethodException e) {
			System.err.print("No Such Method as ");
			System.err.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.print("an illegal argument passing the method ");
			System.err.println(e.getMessage());
		} catch (InvocationTargetException e) {
			System.err.print("an invocation error ");
			System.err.println(e.getMessage());
		}
	}

}

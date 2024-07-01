package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var methodName = method.getName();
                var methodReturnType = method.getReturnType().getName();

                if (methodReturnType.contains(".")) {
                    var buff = methodReturnType.split("\\.");
                    methodReturnType = buff[buff.length - 1];
                }

                String template = "Method %s returns a value of type %s";
                System.out.println(String.format(template, methodName,methodReturnType));
            }
        }
        // END
    }
}

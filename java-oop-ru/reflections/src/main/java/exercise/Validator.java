package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {
    public static List<String> validate(Object address) {
        List<String> result = new ArrayList<>();
        Field[] members = address.getClass().getDeclaredFields();

        for(Field member : members) {
            if(member.isAnnotationPresent(NotNull.class)){
                try{
                    member.setAccessible(true);
                    if (member.get(address) == null){
                        result.add(member.getName());
                    }
                }catch( IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object address) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] members = address.getClass().getDeclaredFields();

        for(Field member : members) {
            if(member.isAnnotationPresent(MinLength.class)) {
                var name = member.getName();
                var length = member.getAnnotation(MinLength.class).minLength();
                try{
                    member.setAccessible(true);
                    var perm = (String) member.get(address);
                    if (perm.length() < length){
                        List<String> errors = result.getOrDefault(name, new ArrayList<>());
                        errors.add("length less than 4");
                        result.put(name, errors);
                    }
                }catch( IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace(System.err);
                }
            }

            if(member.isAnnotationPresent(NotNull.class)) {
                var name = member.getName();
                try{
                    member.setAccessible(true);
                    if (member.get(address) == null){
                        List<String> errors = result.getOrDefault(name, new ArrayList<>());
                        errors.add("can not be null");
                        result.put(name, errors);
                    }
                }catch( IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return result;
    }
}
// END

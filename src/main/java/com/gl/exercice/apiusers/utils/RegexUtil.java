package com.gl.exercice.apiusers.utils;

import com.gl.exercice.apiusers.exeptions.ApplicationException;
import com.gl.exercice.apiusers.exeptions.ConflictExeption;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegexUtil {
    public void validate(RegexType regex, String test, Class<? extends ApplicationException> ex) throws ApplicationException {

        if(Strings.isEmpty(regex.getPattern())
                || Strings.isEmpty(test)
                || ex == null){
            throw new ConflictExeption("Error - RegexUtil: faltan parametros de entrada");
        }

        Pattern pat = Pattern.compile(regex.getPattern());
        Matcher mat = pat.matcher(test);

        if(!mat.matches()){
            try {
                throw ex.getDeclaredConstructor().newInstance();
            } catch (InstantiationException
                    | IllegalAccessException
                    | InvocationTargetException
                    | NoSuchMethodException e) {
                throw new ApplicationException(e.getMessage());
            }
        }

    }

}

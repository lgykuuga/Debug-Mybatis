package com.lgy.test;

import com.lgy.po.Stud;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @Description 代理测试
 * @Author LGy
 * @Date 2020/5/16 11:45
 **/
public class ProxyTest {

    public static void main(String[] args) {

        StudMapper studMapper = (StudMapper) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class<?>[]{StudMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Select annotation = method.getAnnotation(Select.class);
                if (annotation != null) {
                    String[] value = annotation.value();
                    System.out.println(Arrays.toString(value));
                    Map<String, Object> map = builderMethodMap(method, args);
                    parseSQL(Arrays.toString(value), map);
                }


                System.out.println(Arrays.toString(args));

                return null;
            }
        });

        studMapper.selectStudByIdAndGco(1, "0001");

    }


    private static Map<String, Object> builderMethodMap(Method method, Object[] args) {
        Map<String, Object> map = new HashMap<>(args.length);
        Parameter[] parameters = method.getParameters();
        int index[] = {0};
        Arrays.asList(parameters).forEach(parameter -> {
            String name = parameter.getName();
            map.put(name, args[index[0]]);
            index[0]++;
        });

        return map;
    }


    private static void parseSQL(String sql, Map<String, Object> buildMap) {

    }


}

interface StudMapper {

    @Select("select * from stud where id = #{id}")
    Stud selectStudById(Integer id);

    @Select("select * from stud where id = #{id} and gco = #{gco}")
    Stud selectStudByIdAndGco(Integer id, String gco);

    @Select("select * from stud")
    List<Stud> listStud();

}

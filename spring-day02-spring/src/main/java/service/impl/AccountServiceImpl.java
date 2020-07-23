package service.impl;

import service.IAccountService;

import java.util.*;

/**
 * @author 沈泽群
 * @date 2020/7/22
 */
public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;
    private List<String> myList;
    private Set<String> mySet;
    private String[] myArray;
    private Map<String,String> myMap;
    private Properties properties;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myArray=" + Arrays.toString(myArray) +
                ", myMap=" + myMap +
                ", properties=" + properties +
                '}';
    }

    @Override
    public void saveAccount() {
        System.out.println("模拟保存账户");
    }

    public void initMethod(){
        System.out.println("对象的初始化方法");
    }

    public void destroyMethod(){
        System.out.println("对象的销毁方法");
    }
}

package tacos.domain;

/**
 * @author Trace
 * @date 2020/6/21
 * 配料属性实体类
 */

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Data 生成所有缺失的方法，同时还会生成所有以final属性作为参数的构造器
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
    }
}

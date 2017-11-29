/**
 * Created by Administrator on 2017/11/6 0006.
 */
//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下拉选放入的标签id
//参数3: 生成下拉选时,select标签的name属性值
//参数4: 需要回显时,选中哪个option
function loadSelect(typecode,positionId,selectname,selectedId) {
    //1.创建select对象，指定name属性
    //2.添加提示选项
    //3.使用jquery的ajax方法，访问后台的action
    //4.遍历json对象数据
    //5.把组装好的select对象放入页面指定位置
    var $select = $("<select name='"+selectname+"'></select>");
    $select.append($("<option value=''>---请选择---</option>"));
    $.post("${pageContext.request.contextPath}/BaseDictAction", { dict_type_code:typecode},
        function(data){
            $.each(data,function(index, value){
                var $option = $("<option value='"+value['dict_id']+"' >"+value["dict_item_name"]+"</option>");
                if(value['dict_id']==selectedId){
                    //判断是否需要回显 ,如果需要使其被选中
                    $option.attr("selected","selected");
                }
                //并添加到select对象
                $select.append($option);
            });
        }, "json");
    $("#"+positionId).append($select);
}

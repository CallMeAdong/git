<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/jquery-easyui-1.3.0/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>	
	<table id="mytable" class="easyui-datagrid"></table>
	<script type="text/javascript">
		$(function(){
			//页面加载完成后，创建数据表格datagrid
			$("#mytable").datagrid({
				
				//定义标题行所有的列
				columns:[[
				          {title:'编号',field:'id',checkbox:true},
				          {title:'姓名',field:'uname'},
				          {title:'邮箱',field:'email'},
				          {title:'电话',field:'phone'},
				          {title:'学校',field:'school'}
				          ]],
				//指定数据表格发送ajax请求的地址
				url:'${pageContext.request.contextPath }/usermanageaction_pageQuery',
				rownumbers:true,
				singleSelect:false,
				//定义工具栏
				toolbar:[
				         {text:'添加',iconCls:'icon-add',
				        	 //为按钮绑定单击事件
				        	 handler:function(){
				        	 	alert('add...');
				         	 }
				         },
				         {text:'删除',iconCls:'icon-remove',
							handler:function(){
								//获取数据表格中所有选中的行，返回数组对象
								var rows = $("#mytable").datagrid("getSelections");
								
								if(rows.length == 0){
									//没有选中记录，弹出提示
									$.messager.alert("提示信息","请选择需要删除的取派员！","warning");
								}else{
									$.messager.confirm("删除确认","你确定要删除选中的取派员吗？",function(r){
										if(r){											
											var array = new Array();
											//确定,发送请求
											//获取所有选中的取派员的id
											for(var i=0;i<rows.length;i++){
												var staff = rows[i];//json对象
												var uid = staff.uid;
											
												array.push(uid);
											}
											var ids = array.join(",");//1,2,3,4,5
											location.href = "usermanageaction_deleteBatch?ids="+ids;
											/**
											$.post("staffAction_deleteBatch.action",{"ids":ids},function(data){
												alert(data);
											});
											**/
										}
									});

								  }
								}
					         },
				         {text:'修改',iconCls:'icon-edit'},
				         {text:'查询',iconCls:'icon-search'}
				         ],
				//显示分页条
				pagination:true,
				pageList:[3,5,7,10]
			});
		});
	</script>
</body>
</html>
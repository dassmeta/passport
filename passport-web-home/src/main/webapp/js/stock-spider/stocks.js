$(function() {
	// 初始化Table
	$('#stocks-table').bootstrapTable({
		locale : "zh-CN",
		url : '/stocks.json', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		// toolbar: '#toolbar', //工具按钮用哪个容器
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		queryParams : function(res) {
			return {
				pageSize : res.pageSize,
				pageNumber : res.pageNumber
			};
		},// 传递参数（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 20, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		strictSearch : true,
		showColumns : true, // 是否显示所有的列
		showRefresh : true, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		height : 630, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		showToggle : true, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		columns : [ {
			checkbox : true
		}, {
			field : 'id',
			title : 'id'
		}, {
			field : 'code',
			title : '股票代码'
		}, {
			field : 'symbol',
			title : '股票标识'
		}, {
			field : 'com_code',
			title : '公司代码'
		}, {
			field : 'time_to_market',
			title : '上市时间'
		}, {
			field : 'total_capital_stock',
			title : '总股本'
		}, {
			field : 'circulating_stock_capital',
			title : '流动股本'
		}, {
			title : '操作'
		} ],
		responseHandler : function responseHandler(res) {
			return {
				total : res.total,
				rows : res.rows
			};
		},
		formatter:function(value,row,index){
			return [
			        '<a href="http://blog.163.com/wp_2002wp/blog/path?id='+row.id+'"><span>编辑</span></a>',
			         '<a onClick="del('+row.valid+','+row.id+')" href="javascript:;"><span>删除</span></a>'
			      ].join('   ');
		}
	});
});

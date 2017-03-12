var appManageTable = $('#app-manage-table'), selections = [], appManageAddBtn = $('#app-manage-add-btn');
/**
 * 注册新应用按钮点击事件
 */
appManageAddBtn.on("click", function(event) {
	window.location.href = 'registration';
});

/**
 * table search事件 清除原来的数据重新填充 修复搜索无数据时表格无变化bug
 */
appManageTable.on("search.bs.table", function() {
	appManageTable.bootstrapTable('removeAll');
});

/**
 * table 初始化
 */
appManageTable
		.bootstrapTable({
			toolbar : "#toolbar",
			search : "true",
			showRefresh : "true",
			showToggle : "true",
			showColumns : "true",
			showExport : "true",
			sortable : 'true',
			detailView : "true",
			detailFormatter : "detailFormatter",
			minimumCountColumns : "2",
			showPaginationSwitch : "true",
			pagination : "true",
			idField : "id",
			pageList : "[10, 25, 50, 100, ALL]",
			showFooter : "false",
			sidePagination : "server",
			url : "apps",
			method : "post",
			dataType : "json",
			sortOrder : "desc",
			cache : "false",
			undefinedText : "--",
			striped : "true",
			columns : [
					{
						title : 'ID',
						field : 'id',
						align : 'center',
						valign : 'middle',
						width : '5%'
					},
					{
						title : '应用名称',
						field : 'appName',
						sortable : true,
						width : '30%'
					},
					{
						title : '应用地址',
						field : 'appUrl',
						sortable : true,
						width : '25%'
					},
					{
						title : '修改时间',
						field : 'modifyTime',
						width : '20%',
						sortable : true,
						formatter : function(value, row, index) {
							return new Date(value).toLocaleString();
						}
					},
					{
						title : '操作',
						field : 'id',
						align : 'center',
						width : '20%',
						formatter : function(value, row, index) {
							var c = '<button type="button"  class="btn btn-xs btn-success">菜单</button>';
							var e = '<button type="button" style="margin-left: 10px;" class="btn btn-xs btn-warning">编辑</button>';
							var d = '<button type="button" style="margin-left: 10px;" class="btn btn-xs btn-danger">删除</button>';
							return c + e + d;
						}
					} ]
		});

/**
 * 详情页数据格式化
 * 
 * @param index
 * @param row
 * @returns
 */
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function(key, value) {
		html.push('<p><b>' + key + ':</b> ' + (value == null ? "" : value)
				+ '</p>');
	});
	return html.join('');
}

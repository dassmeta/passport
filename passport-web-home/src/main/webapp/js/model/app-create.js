var appCreateSaveBtn = $('#app-create-save-btn'), appCreateResetBtn = $('#app-create-reset-btn'),
appCreateReturnBtn = $('#app-create-return-btn'), appCreateForm = $('#app-create-form'),
appCreateModal = $('#app-create-modal');
/**
 * 注册新应用保存按钮点击事件
 */
appCreateSaveBtn.on("click", function(event) {
	var data = appCreateForm.serializeObject();
	$.ajax({
		type : "post",
		url : "create",
		contentType : "application/json;charset=utf-8",
		// data : appCreateForm.serialize(),
		data : data,
		dataType : "json",
		success : function(data) {
			if(data.valid){
				window.location.href = 'manage';
			}else{
				appCreateModal.modal('show');
				appCreateModal.find(".modal-body >p").html(data.message);
			}
		},
		error : function(data) {
			console.log(data);
		}
	});
});

/**
 * 注册新应用重置按钮点击事件
 */
appCreateResetBtn.on("click", function(event) {
	$("#app-create-form")[0].reset();
});

/**
 * 注册新应用返回按钮点击事件
 */
appCreateReturnBtn.on("click", function(event) {
	history.back(-1);
});

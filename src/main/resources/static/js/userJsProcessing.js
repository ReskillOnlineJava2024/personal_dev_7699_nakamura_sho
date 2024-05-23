/** user側のJavaScriptの処理をひとまとめにしたもの **/


//アカウント新規作成の入力のチェック
function accountValidate() {
    var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("passwordConfirm").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var passwordPattern = /^(?=.*\d)(?=.*[a-z]).{8,16}$/;
    
    
    if (name === "" || email === "" || password === "" || passwordConfirm === "") {
        alert("未入力の項目があります");
        return false;
    }
    
    if(!passwordPattern.test(password)) {
		 alert("英数字8～16文字以内のパスワードを設定してください");
		 return false;
	}
	
	if(passwordConfirm !== password) {
		 alert("入力されたパスワードと確認用パスワードが一致していません。");
		 return false;
	}
	
	return true;	
	
}

//目玉マークを押すとパスワードが表示される処理
function pushHideButton() {
    var txtPass = document.getElementById("password");
    var btnEye = document.getElementById("buttonEye");
    if (txtPass.type === "text") {
      txtPass.type = "password";
      btnEye.className = "fa fa-eye";
    } else {
      txtPass.type = "text";
      btnEye.className = "fa fa-eye-slash";
    }
}

//ログイン時の未入力チェック
function validate() {
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    
    if (email === "" || password === "") {
        alert("未入力の項目があります");
        return false;
    }
	
	return true;
}

//アカウント情報更新時の入力チェックと更新ボタンクリック時のログアウトの確認ダイアログ表示
function updateValidate() {
    var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("passwordConfirm").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var passwordPattern = /^(?=.*\d)(?=.*[a-z]).{8,16}$/;
    
    
    if (name === "" || email === "" || password === "" || passwordConfirm === "") {
        alert("未入力の項目があります");
        return false;
    }
    
    if(!passwordPattern.test(password)) {
		 alert("英数字8～16文字以内のパスワードを設定してください");
		 return false;
	}
	
	if(passwordConfirm !== password) {
		 alert("入力されたパスワードと確認用パスワードが一致していません。");
		 return false;
	}
	
	
	if (window.confirm('情報の更新後ログアウトします。更新しますか？')) {
        return true;
    } else {
        return false;
    }
}
function validate() {
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    
    if (email === "" || password === "") {
        alert("未入力の項目があります");
        return false;
    }
	
	return true;
}
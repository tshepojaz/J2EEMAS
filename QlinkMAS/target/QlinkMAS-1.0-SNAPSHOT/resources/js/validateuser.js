/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function validregform(){
    var username = document.getElementById('reguser:username').value;
    var password = document.getElementById('reguser:password').value;
    var passwordv = document.getElementById('reguser:passwordv').value;
    var role = document.getElementById('reguser:userole').value;
    
    if((username == "") || (username == undefined)){
        alert("Username is required");
        return false;
    }
    else if ((password == "") || (password == undefined)){
        alert("Password is required");
        return false;
    }
    else if((passwordv == "") || (passwordv == undefined)){
        alert("Password verification is required");
        return false;
    }
    else if ((role == '00') || (role == undefined)){
        alert("Please select the user roles");
        return false;
    }else{
       return true;
    }
}




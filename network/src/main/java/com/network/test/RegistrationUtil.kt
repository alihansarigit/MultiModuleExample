package com.network.test

object RegistrationUtil {

    private var users = listOf("Ali","Veli","Ayşe")
    /*
    Olasılıklar
    Username ve Password boş olabilir
    Username alınmış olabilir
    Şifreler aynı olmayabilir
    Şifre 2 haneden küçük olabilir
     */
    fun validateRegistrationInput(
        username:String,
        password:String,
        confirmedPassword:String):Boolean{
        if(username.isEmpty() || password.isEmpty()){
            return false
        }
        if(username in users){
            return false
        }
        if(!password.equals(confirmedPassword)){
            return false
        }
        if(password.count{ it.isDigit() } < 2){
            return false
        }
        return true
    }
}
package Library;

public class MyException extends Exception {

private String myMsg = "";

public MyException(String userMsg) {
// user-defined message
myMsg = userMsg;
}
public MyException() {
// default message
myMsg = "Invalid input !";
}
@Override
public String getMessage() {
return myMsg;
}

}
package vn.tayjava.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserStatus {
    @JsonProperty("active") // JsonProperty cho phép request data nhập vào là chữ thường
    ACTIVE,
    @JsonProperty("inactive")
    INACTIVE,
    @JsonProperty("none")
    NONE // Nếu không để validate thì sẽ cho phép nhận null và các giá trị trong này
}

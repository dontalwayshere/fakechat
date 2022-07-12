package com.fakechat.practice.common.msg;

/**
 * @param <T>
 * 说明：{ "status":xxx,"message":"xxx","ok":xxx,"data":xxx}
 */

public class MessageBox<T> extends Message {
    protected T data;

    /*Constructor*/

    public MessageBox() {
        super();
        this.data = null;
    }

    public MessageBox(T data) {
        this(BOOLEAN_OK, data);
    }

    public MessageBox(boolean ok, T data) {
        super(BOOLEAN_OK);
        this.data = data;
    }

    public MessageBox(String message, boolean ok, T data) {
        super(message, ok);
        this.data = data;
    }

    public MessageBox(int status, String message, boolean ok, T data) {
        super(status, message, ok);
        this.data = data;
    }

    /*Setter And Getter*/

    public T getData() {
        return data;
    }

    public MessageBox<T> setData(T data) {
        this.data = data;
        return this;
    }

    /*Static method*/

    /**
     * @return - { "status":1,"message":"成功","ok":true,"data":xxx}
     */
    public static <E> MessageBox<E> ok(E data) {
        return new MessageBox<>(BOOLEAN_OK, data);
    }

    public static MessageBox<String> ok(String data) {
        return new MessageBox<>(BOOLEAN_OK, data);
    }

    public static <E> MessageBox<E> ok(String message, E data) {
        return new MessageBox<>(message, BOOLEAN_OK, data);
    }

    public static <E> MessageBox<E> okMsg() {
        return new MessageBox<>(MESSAGE_OK, BOOLEAN_OK, null);
    }

    public static <E> MessageBox<E> okMsg(String message) {
        return new MessageBox<>(message, BOOLEAN_OK, null);
    }

    /**
     * @return - { "status":0,"message":"失败","ok":false,"data":xxx}
     */
    public static <E> MessageBox<E> fail(E data) {
        return new MessageBox<>(BOOLEAN_FAIL, data);
    }

    public static MessageBox<String> fail(String data) {
        return new MessageBox<>(BOOLEAN_FAIL, data);
    }

    public static <E> MessageBox<E> fail(String message, E data) {
        return new MessageBox<>(message, BOOLEAN_FAIL, data);
    }

    public static <E> MessageBox<E> failMsg(String message) {
        return new MessageBox<>(message, BOOLEAN_FAIL, null);
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"status\": " + status + ",\n" +
                "    \"ok\": " + ok + ",\n" +
                "    \"message\": " + message + ",\n" +
                "    \"data\": " + data.toString() + "\n" +
                "}\n";
    }
}

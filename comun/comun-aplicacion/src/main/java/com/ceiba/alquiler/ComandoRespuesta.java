package com.ceiba.alquiler;

public class ComandoRespuesta<T> {

    private T respuesta;

    public ComandoRespuesta(T respuesta) {
        this.respuesta = respuesta;
    }

    public T getRespuesta() {
        return respuesta;
    }
}

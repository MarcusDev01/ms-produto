package com.github.MarcusDev01.ms.produto.exceptions.dto;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDTO extends CustomErrorDTO{
    private List<FieldMessageDTO> errors = new ArrayList<>();

    public ValidationErrorDTO(Instant timestamp, Integer status, String error, String path){
        super(timestamp,status,error,path);
    }

    //metodo para adicionar erros a list
    public void addError(String filedName, String message){
        //remove erro de campo duplicado
        errors.removeIf(x-> x.getFielName().equals(filedName));
        errors.add(new FieldMessageDTO(filedName,message));
    }
}

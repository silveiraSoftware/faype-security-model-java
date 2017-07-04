package com.faype.security.core.global;


import com.faype.security.domain.Token;

/**
 * @author wmfsystem
 */
public class ThreadScope {

    /**
     * irá ignorar a checagem de propriedade dos registros do Tenacy
     */
    public static final ThreadLocal<Boolean> ignoreCheckOwnership = new ThreadLocal<>();
    /**
     * token da requisição
     */
    public static final ThreadLocal<Token> token = new ThreadLocal<>();
}

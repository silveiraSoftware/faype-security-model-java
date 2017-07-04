package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.Token;
import com.faype.security.domain.User;
import com.faype.security.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class TokenService extends GenericService<TokenRepository, Token, String> {

    @Autowired
    private TokenService tokenService;

    @Transactional
    private Token createTokenByUser(User user) {
        Token token = new Token();
        LocalDateTime datePlus = LocalDateTime.now().plusDays(2);
        token.setExpirateAt(datePlus);
        token.setUser(user);
        token.setInformation(user.toString());
        token.setValue(generateTokenByUser(user));

        return tokenService.save(token);
    }

    private String generateTokenByUser(User user) {
        NetworkInterface netInf = null;
        try {
            netInf = NetworkInterface.getNetworkInterfaces().nextElement();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] mac = new byte[0];
        try {
            mac = netInf.getHardwareAddress();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }

        UUID uuid = UUID.nameUUIDFromBytes("amdfdn".getBytes());
        String token = sb.toString().concat(uuid.toString());
    }
}

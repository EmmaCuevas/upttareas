/**
 * 
 */
package com.dominio.controller;

//import javax.ws.rs.core.Response;

/**
 * @author diego.molina
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dominio.impl.WebSocketImpl;

@RestController
@RequestMapping("/ws")
public class WebSocketController {

	@Autowired
	private WebSocketImpl webSocketProcess;

	/**
	 * Enviar un mensaje al cliente especificado
	 * @param token
	 * @param msg
	 */
	@PostMapping(value = "sendMsgToClientById")
	public void sendMsgToClientById(@RequestParam String token, @RequestParam String text){
	    try {

			webSocketProcess.sendMessage(token,text); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Enviar mensajes a todos los clientes
	 * @param msg
	 */
	@PostMapping(value = "sendMsgToAllClient")
	public void sendMsgToAllClient(@RequestParam String text){
	    try {
	        webSocketProcess.sendAllMessage(text);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}

package com.yyx.chatroom.controller;

import com.yyx.chatroom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Date: 2024/11/2 14:29
 * @description:
 *@Title: RoomController
 *@Package :com.yyx.chatroom.controller
 */
@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomService roomService;


    @GetMapping("join")
    //加入聊天室
    public String joinRoom(String roomId,String userId){
        //传过来的参数进行校验
        if (roomId==null || userId==null){
            return "参数错误";
        }
        return  roomService.joinRoom(roomId,userId);
    }

    @GetMapping("leave")
    //离开聊天室
    public String leaveRoom(String roomId,String userId){
        //传过来的参数进行校验
        if (roomId==null || userId==null){
            return "参数错误";
        }
        return  roomService.leaveRoom(roomId,userId);
    }
}

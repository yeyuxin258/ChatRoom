package com.yyx.chatroom.service;

/*
 * @Date: 2024/11/2 14:29
 * @description:
 *@Title: RoomService
 *@Package :com.yyx.chatroom.service
 */
public interface RoomService {
    //加入聊天室
    String joinRoom(String roomId, String userId);

    //离开聊天室
    String leaveRoom(String roomId, String userId);
}

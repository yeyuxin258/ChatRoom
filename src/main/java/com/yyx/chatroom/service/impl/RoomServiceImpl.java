package com.yyx.chatroom.service.impl;

import com.yyx.chatroom.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @Date: 2024/11/2 14:30
 * @description:
 *@Title: RoomServiceImpl
 *@Package :com.yyx.chatroom.service.impl
 */
@Service
public class RoomServiceImpl implements RoomService {
    //初始化容器 存储 聊天室与聊天室内的成员
    static HashMap<String, List<String>> map =new HashMap<>();


    //加入聊天室
    @Override
    public String joinRoom(String roomId, String userId) {
        //判断该聊天室是否存在
        if (!map.containsKey(roomId)){
            //不存在，则新建聊天室并加入
            List<String> list =new ArrayList<>();
            list.add(userId);
            map.put(roomId,list);
        }else {
            //存在，加入该聊天室
            List<String> list = map.get(roomId);
            //当该用户不在该聊天室时存入
            if (!list.contains(userId)){
                list.add(userId);
            }
            map.put(roomId,list);
        }
        List<String> list = map.get(roomId);
        String tip="欢迎加入"+roomId+"号聊天室，当前与你同在该聊天的成员有:";
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(userId)){
                tip=tip+list.get(i)+" ";
            }
        }

        return tip;
    }
    //离开聊天室
    @Override
    public String leaveRoom(String roomId, String userId) {
        List<String> list=null;
        //判断该聊天室是否存在
        if (!map.containsKey(roomId)){
            return "该聊天室不存在";
        }
        list = map.get(roomId);
        if (!list.contains(userId)){
            return "你不在该聊天室，无需离开";
        }
        list.remove(userId);
        String tip="你已离开"+roomId+"号聊天室，当前还在该聊天的成员有:";

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(userId)){
                tip=tip+list.get(i)+" ";
            }
        }
        //该聊天室无人存在时 ，将该聊天室删除
        if (list.size()==0){
            map.remove(roomId);
        }
        return tip;
    }
}

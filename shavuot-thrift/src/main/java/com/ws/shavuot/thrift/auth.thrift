namespace java com.ws.shavuot.thrift.auth


typedef i16 char
typedef i32 int
typedef i64 long



struct UserStruct {
    1:  required string userId;
    2:  optional string userName;
}



// shavuot-auth对外提供服务的接口
service AuthService {

    list<UserStruct> getUsersByRoleId(1:string roleId);
}
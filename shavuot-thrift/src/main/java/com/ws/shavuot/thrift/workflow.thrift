namespace java com.ws.shavuot.thrift.workflow


typedef i16 char
typedef i32 int
typedef i64 long


struct StartProcessStruct {
    1:  required string key;
    2:  optional string userId;
    3:  optional string businessKey;
    4:  optional map<string,string> variables;
}

struct CreateTaskStruct {
    1: required list<string> userIds;
    2: optional string name;
    3: optional long dueDate;
}

struct TaskStruct {
    1: string id;
    2: string executionId
    3: string processInstanceId;
    4: string processDefinitionId
    5: string name;
    6: string description;
    7: string taskDefinitionKey;
    8: string owner;
    9: string assignee;
    10: i32 priority;
    11: long createTime;
    12: long dueDate;
    13: string category
    14: string parentTaskId
    15: string tenantId
    16: string formKey;

    17: string businessKey;
}

struct IdentitylinkStruct {
    1: string id
    2: i32 rev;
    3: string groupId;
    4: string type;
    5: string userId;
    6: string taskId;
    7: string processInstanceId;
    8: string processDefinitionId;
}

struct ReturnStruct {
    1: optional string processInstanceId;
    2: optional list<TaskStruct> taskStructList;
    3: optional list<IdentitylinkStruct> identitylinkStructList;
}

enum ErrorCode {
    EX_2001 = 2001; //系统异常
    EX_1002 = 1002; //请求参数异常
}

exception WorkflowException {
    1: required ErrorCode errorCode;
    2: required string description;
    3: optional string caseInfo;
}

// shavuot-workflow对外提供服务的接口
service WorkflowService {

    // 启动流程
    ReturnStruct startProcess(1:StartProcessStruct startProcessStruct) throws (1: WorkflowException ex);
    // 挂起流程
    void suspendProcess(1:string processInstanceId) throws (1: WorkflowException ex);
    // 恢复流程
    void activateProcess(1:string processInstanceId) throws (1: WorkflowException ex);

    // 认领任务
    void claim(1:string taskId, 2:string userId) throws (1: WorkflowException ex);
    // 完成任务
    ReturnStruct complete(1:string taskId, 2:map<string,string> variables) throws (1: WorkflowException ex);
    // 创建任务
    ReturnStruct createTask(1:CreateTaskStruct createTaskStruct) throws (1: WorkflowException ex);

}
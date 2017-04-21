/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ws.shavuot.thrift.workflow;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-04-13")
public class IdentitylinkStruct implements org.apache.thrift.TBase<IdentitylinkStruct, IdentitylinkStruct._Fields>, java.io.Serializable, Cloneable, Comparable<IdentitylinkStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("IdentitylinkStruct");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField REV_FIELD_DESC = new org.apache.thrift.protocol.TField("rev", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField GROUP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("groupId", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField TASK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("taskId", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField PROCESS_INSTANCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("processInstanceId", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField PROCESS_DEFINITION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("processDefinitionId", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new IdentitylinkStructStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new IdentitylinkStructTupleSchemeFactory();

  public java.lang.String id; // required
  public int rev; // required
  public java.lang.String groupId; // required
  public java.lang.String type; // required
  public java.lang.String userId; // required
  public java.lang.String taskId; // required
  public java.lang.String processInstanceId; // required
  public java.lang.String processDefinitionId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    REV((short)2, "rev"),
    GROUP_ID((short)3, "groupId"),
    TYPE((short)4, "type"),
    USER_ID((short)5, "userId"),
    TASK_ID((short)6, "taskId"),
    PROCESS_INSTANCE_ID((short)7, "processInstanceId"),
    PROCESS_DEFINITION_ID((short)8, "processDefinitionId");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // REV
          return REV;
        case 3: // GROUP_ID
          return GROUP_ID;
        case 4: // TYPE
          return TYPE;
        case 5: // USER_ID
          return USER_ID;
        case 6: // TASK_ID
          return TASK_ID;
        case 7: // PROCESS_INSTANCE_ID
          return PROCESS_INSTANCE_ID;
        case 8: // PROCESS_DEFINITION_ID
          return PROCESS_DEFINITION_ID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __REV_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REV, new org.apache.thrift.meta_data.FieldMetaData("rev", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.GROUP_ID, new org.apache.thrift.meta_data.FieldMetaData("groupId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TASK_ID, new org.apache.thrift.meta_data.FieldMetaData("taskId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROCESS_INSTANCE_ID, new org.apache.thrift.meta_data.FieldMetaData("processInstanceId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROCESS_DEFINITION_ID, new org.apache.thrift.meta_data.FieldMetaData("processDefinitionId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(IdentitylinkStruct.class, metaDataMap);
  }

  public IdentitylinkStruct() {
  }

  public IdentitylinkStruct(
    java.lang.String id,
    int rev,
    java.lang.String groupId,
    java.lang.String type,
    java.lang.String userId,
    java.lang.String taskId,
    java.lang.String processInstanceId,
    java.lang.String processDefinitionId)
  {
    this();
    this.id = id;
    this.rev = rev;
    setRevIsSet(true);
    this.groupId = groupId;
    this.type = type;
    this.userId = userId;
    this.taskId = taskId;
    this.processInstanceId = processInstanceId;
    this.processDefinitionId = processDefinitionId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public IdentitylinkStruct(IdentitylinkStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetId()) {
      this.id = other.id;
    }
    this.rev = other.rev;
    if (other.isSetGroupId()) {
      this.groupId = other.groupId;
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetUserId()) {
      this.userId = other.userId;
    }
    if (other.isSetTaskId()) {
      this.taskId = other.taskId;
    }
    if (other.isSetProcessInstanceId()) {
      this.processInstanceId = other.processInstanceId;
    }
    if (other.isSetProcessDefinitionId()) {
      this.processDefinitionId = other.processDefinitionId;
    }
  }

  public IdentitylinkStruct deepCopy() {
    return new IdentitylinkStruct(this);
  }

  @Override
  public void clear() {
    this.id = null;
    setRevIsSet(false);
    this.rev = 0;
    this.groupId = null;
    this.type = null;
    this.userId = null;
    this.taskId = null;
    this.processInstanceId = null;
    this.processDefinitionId = null;
  }

  public java.lang.String getId() {
    return this.id;
  }

  public IdentitylinkStruct setId(java.lang.String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public int getRev() {
    return this.rev;
  }

  public IdentitylinkStruct setRev(int rev) {
    this.rev = rev;
    setRevIsSet(true);
    return this;
  }

  public void unsetRev() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __REV_ISSET_ID);
  }

  /** Returns true if field rev is set (has been assigned a value) and false otherwise */
  public boolean isSetRev() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __REV_ISSET_ID);
  }

  public void setRevIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __REV_ISSET_ID, value);
  }

  public java.lang.String getGroupId() {
    return this.groupId;
  }

  public IdentitylinkStruct setGroupId(java.lang.String groupId) {
    this.groupId = groupId;
    return this;
  }

  public void unsetGroupId() {
    this.groupId = null;
  }

  /** Returns true if field groupId is set (has been assigned a value) and false otherwise */
  public boolean isSetGroupId() {
    return this.groupId != null;
  }

  public void setGroupIdIsSet(boolean value) {
    if (!value) {
      this.groupId = null;
    }
  }

  public java.lang.String getType() {
    return this.type;
  }

  public IdentitylinkStruct setType(java.lang.String type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public java.lang.String getUserId() {
    return this.userId;
  }

  public IdentitylinkStruct setUserId(java.lang.String userId) {
    this.userId = userId;
    return this;
  }

  public void unsetUserId() {
    this.userId = null;
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return this.userId != null;
  }

  public void setUserIdIsSet(boolean value) {
    if (!value) {
      this.userId = null;
    }
  }

  public java.lang.String getTaskId() {
    return this.taskId;
  }

  public IdentitylinkStruct setTaskId(java.lang.String taskId) {
    this.taskId = taskId;
    return this;
  }

  public void unsetTaskId() {
    this.taskId = null;
  }

  /** Returns true if field taskId is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskId() {
    return this.taskId != null;
  }

  public void setTaskIdIsSet(boolean value) {
    if (!value) {
      this.taskId = null;
    }
  }

  public java.lang.String getProcessInstanceId() {
    return this.processInstanceId;
  }

  public IdentitylinkStruct setProcessInstanceId(java.lang.String processInstanceId) {
    this.processInstanceId = processInstanceId;
    return this;
  }

  public void unsetProcessInstanceId() {
    this.processInstanceId = null;
  }

  /** Returns true if field processInstanceId is set (has been assigned a value) and false otherwise */
  public boolean isSetProcessInstanceId() {
    return this.processInstanceId != null;
  }

  public void setProcessInstanceIdIsSet(boolean value) {
    if (!value) {
      this.processInstanceId = null;
    }
  }

  public java.lang.String getProcessDefinitionId() {
    return this.processDefinitionId;
  }

  public IdentitylinkStruct setProcessDefinitionId(java.lang.String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
    return this;
  }

  public void unsetProcessDefinitionId() {
    this.processDefinitionId = null;
  }

  /** Returns true if field processDefinitionId is set (has been assigned a value) and false otherwise */
  public boolean isSetProcessDefinitionId() {
    return this.processDefinitionId != null;
  }

  public void setProcessDefinitionIdIsSet(boolean value) {
    if (!value) {
      this.processDefinitionId = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.String)value);
      }
      break;

    case REV:
      if (value == null) {
        unsetRev();
      } else {
        setRev((java.lang.Integer)value);
      }
      break;

    case GROUP_ID:
      if (value == null) {
        unsetGroupId();
      } else {
        setGroupId((java.lang.String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((java.lang.String)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((java.lang.String)value);
      }
      break;

    case TASK_ID:
      if (value == null) {
        unsetTaskId();
      } else {
        setTaskId((java.lang.String)value);
      }
      break;

    case PROCESS_INSTANCE_ID:
      if (value == null) {
        unsetProcessInstanceId();
      } else {
        setProcessInstanceId((java.lang.String)value);
      }
      break;

    case PROCESS_DEFINITION_ID:
      if (value == null) {
        unsetProcessDefinitionId();
      } else {
        setProcessDefinitionId((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case REV:
      return getRev();

    case GROUP_ID:
      return getGroupId();

    case TYPE:
      return getType();

    case USER_ID:
      return getUserId();

    case TASK_ID:
      return getTaskId();

    case PROCESS_INSTANCE_ID:
      return getProcessInstanceId();

    case PROCESS_DEFINITION_ID:
      return getProcessDefinitionId();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case REV:
      return isSetRev();
    case GROUP_ID:
      return isSetGroupId();
    case TYPE:
      return isSetType();
    case USER_ID:
      return isSetUserId();
    case TASK_ID:
      return isSetTaskId();
    case PROCESS_INSTANCE_ID:
      return isSetProcessInstanceId();
    case PROCESS_DEFINITION_ID:
      return isSetProcessDefinitionId();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof IdentitylinkStruct)
      return this.equals((IdentitylinkStruct)that);
    return false;
  }

  public boolean equals(IdentitylinkStruct that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_rev = true;
    boolean that_present_rev = true;
    if (this_present_rev || that_present_rev) {
      if (!(this_present_rev && that_present_rev))
        return false;
      if (this.rev != that.rev)
        return false;
    }

    boolean this_present_groupId = true && this.isSetGroupId();
    boolean that_present_groupId = true && that.isSetGroupId();
    if (this_present_groupId || that_present_groupId) {
      if (!(this_present_groupId && that_present_groupId))
        return false;
      if (!this.groupId.equals(that.groupId))
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_userId = true && this.isSetUserId();
    boolean that_present_userId = true && that.isSetUserId();
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (!this.userId.equals(that.userId))
        return false;
    }

    boolean this_present_taskId = true && this.isSetTaskId();
    boolean that_present_taskId = true && that.isSetTaskId();
    if (this_present_taskId || that_present_taskId) {
      if (!(this_present_taskId && that_present_taskId))
        return false;
      if (!this.taskId.equals(that.taskId))
        return false;
    }

    boolean this_present_processInstanceId = true && this.isSetProcessInstanceId();
    boolean that_present_processInstanceId = true && that.isSetProcessInstanceId();
    if (this_present_processInstanceId || that_present_processInstanceId) {
      if (!(this_present_processInstanceId && that_present_processInstanceId))
        return false;
      if (!this.processInstanceId.equals(that.processInstanceId))
        return false;
    }

    boolean this_present_processDefinitionId = true && this.isSetProcessDefinitionId();
    boolean that_present_processDefinitionId = true && that.isSetProcessDefinitionId();
    if (this_present_processDefinitionId || that_present_processDefinitionId) {
      if (!(this_present_processDefinitionId && that_present_processDefinitionId))
        return false;
      if (!this.processDefinitionId.equals(that.processDefinitionId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetId()) ? 131071 : 524287);
    if (isSetId())
      hashCode = hashCode * 8191 + id.hashCode();

    hashCode = hashCode * 8191 + rev;

    hashCode = hashCode * 8191 + ((isSetGroupId()) ? 131071 : 524287);
    if (isSetGroupId())
      hashCode = hashCode * 8191 + groupId.hashCode();

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.hashCode();

    hashCode = hashCode * 8191 + ((isSetUserId()) ? 131071 : 524287);
    if (isSetUserId())
      hashCode = hashCode * 8191 + userId.hashCode();

    hashCode = hashCode * 8191 + ((isSetTaskId()) ? 131071 : 524287);
    if (isSetTaskId())
      hashCode = hashCode * 8191 + taskId.hashCode();

    hashCode = hashCode * 8191 + ((isSetProcessInstanceId()) ? 131071 : 524287);
    if (isSetProcessInstanceId())
      hashCode = hashCode * 8191 + processInstanceId.hashCode();

    hashCode = hashCode * 8191 + ((isSetProcessDefinitionId()) ? 131071 : 524287);
    if (isSetProcessDefinitionId())
      hashCode = hashCode * 8191 + processDefinitionId.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(IdentitylinkStruct other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetRev()).compareTo(other.isSetRev());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRev()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rev, other.rev);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetGroupId()).compareTo(other.isSetGroupId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroupId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groupId, other.groupId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTaskId()).compareTo(other.isSetTaskId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskId, other.taskId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetProcessInstanceId()).compareTo(other.isSetProcessInstanceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProcessInstanceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processInstanceId, other.processInstanceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetProcessDefinitionId()).compareTo(other.isSetProcessDefinitionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProcessDefinitionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processDefinitionId, other.processDefinitionId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("IdentitylinkStruct(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("rev:");
    sb.append(this.rev);
    first = false;
    if (!first) sb.append(", ");
    sb.append("groupId:");
    if (this.groupId == null) {
      sb.append("null");
    } else {
      sb.append(this.groupId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userId:");
    if (this.userId == null) {
      sb.append("null");
    } else {
      sb.append(this.userId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("taskId:");
    if (this.taskId == null) {
      sb.append("null");
    } else {
      sb.append(this.taskId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("processInstanceId:");
    if (this.processInstanceId == null) {
      sb.append("null");
    } else {
      sb.append(this.processInstanceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("processDefinitionId:");
    if (this.processDefinitionId == null) {
      sb.append("null");
    } else {
      sb.append(this.processDefinitionId);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class IdentitylinkStructStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IdentitylinkStructStandardScheme getScheme() {
      return new IdentitylinkStructStandardScheme();
    }
  }

  private static class IdentitylinkStructStandardScheme extends org.apache.thrift.scheme.StandardScheme<IdentitylinkStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, IdentitylinkStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REV
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.rev = iprot.readI32();
              struct.setRevIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // GROUP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.groupId = iprot.readString();
              struct.setGroupIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.type = iprot.readString();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userId = iprot.readString();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TASK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.taskId = iprot.readString();
              struct.setTaskIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // PROCESS_INSTANCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.processInstanceId = iprot.readString();
              struct.setProcessInstanceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // PROCESS_DEFINITION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.processDefinitionId = iprot.readString();
              struct.setProcessDefinitionIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, IdentitylinkStruct struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(REV_FIELD_DESC);
      oprot.writeI32(struct.rev);
      oprot.writeFieldEnd();
      if (struct.groupId != null) {
        oprot.writeFieldBegin(GROUP_ID_FIELD_DESC);
        oprot.writeString(struct.groupId);
        oprot.writeFieldEnd();
      }
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeString(struct.type);
        oprot.writeFieldEnd();
      }
      if (struct.userId != null) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeString(struct.userId);
        oprot.writeFieldEnd();
      }
      if (struct.taskId != null) {
        oprot.writeFieldBegin(TASK_ID_FIELD_DESC);
        oprot.writeString(struct.taskId);
        oprot.writeFieldEnd();
      }
      if (struct.processInstanceId != null) {
        oprot.writeFieldBegin(PROCESS_INSTANCE_ID_FIELD_DESC);
        oprot.writeString(struct.processInstanceId);
        oprot.writeFieldEnd();
      }
      if (struct.processDefinitionId != null) {
        oprot.writeFieldBegin(PROCESS_DEFINITION_ID_FIELD_DESC);
        oprot.writeString(struct.processDefinitionId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IdentitylinkStructTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IdentitylinkStructTupleScheme getScheme() {
      return new IdentitylinkStructTupleScheme();
    }
  }

  private static class IdentitylinkStructTupleScheme extends org.apache.thrift.scheme.TupleScheme<IdentitylinkStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, IdentitylinkStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetRev()) {
        optionals.set(1);
      }
      if (struct.isSetGroupId()) {
        optionals.set(2);
      }
      if (struct.isSetType()) {
        optionals.set(3);
      }
      if (struct.isSetUserId()) {
        optionals.set(4);
      }
      if (struct.isSetTaskId()) {
        optionals.set(5);
      }
      if (struct.isSetProcessInstanceId()) {
        optionals.set(6);
      }
      if (struct.isSetProcessDefinitionId()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
      if (struct.isSetRev()) {
        oprot.writeI32(struct.rev);
      }
      if (struct.isSetGroupId()) {
        oprot.writeString(struct.groupId);
      }
      if (struct.isSetType()) {
        oprot.writeString(struct.type);
      }
      if (struct.isSetUserId()) {
        oprot.writeString(struct.userId);
      }
      if (struct.isSetTaskId()) {
        oprot.writeString(struct.taskId);
      }
      if (struct.isSetProcessInstanceId()) {
        oprot.writeString(struct.processInstanceId);
      }
      if (struct.isSetProcessDefinitionId()) {
        oprot.writeString(struct.processDefinitionId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, IdentitylinkStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.rev = iprot.readI32();
        struct.setRevIsSet(true);
      }
      if (incoming.get(2)) {
        struct.groupId = iprot.readString();
        struct.setGroupIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.type = iprot.readString();
        struct.setTypeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.userId = iprot.readString();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(5)) {
        struct.taskId = iprot.readString();
        struct.setTaskIdIsSet(true);
      }
      if (incoming.get(6)) {
        struct.processInstanceId = iprot.readString();
        struct.setProcessInstanceIdIsSet(true);
      }
      if (incoming.get(7)) {
        struct.processDefinitionId = iprot.readString();
        struct.setProcessDefinitionIdIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}


<template>
  <el-row>
    <el-col :span="24">
      <el-page-header @back="goBack" content="注册"></el-page-header>
    </el-col>
    <el-col :span="10" :offset="7">
      <el-card class="box-card" shadow="always">
        <div style="text-align: center">
          <p style="font-family:'Hiragino Sans GB';font-size: $--font-size-large">注册</p>
        </div>
        <el-divider></el-divider>
        <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-width="80px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="name">
            <el-input type="text" v-model="ruleForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="重复密码" prop="repeatPassword">
            <el-input type="password" v-model="ruleForm.repeatPassword" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input type="text" v-model="ruleForm.phone" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
            <div style="float:right">
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </div>
          </el-form-item>
        </el-form>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
import axios from "axios";

export default {
  name: "Join",
  data() {
    var validateName = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入用户名"));
      } else {
        if (this.ruleForm.checkName !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPassword !== "") {
          this.$refs.ruleForm.validateField("checkPassword");
        }
        callback();
      }
    };
    var validateRepeatPassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.password) {
        callback(new Error("两次输入的密码不一致!"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入电话"));
      } else {
        if (this.ruleForm.checkPassword !== "") {
          this.$refs.ruleForm.validateField("checkPassword");
        }
        callback();
      }
    };
    return {
      imgs: [require("../assets/004.jpeg"), require("../assets/002.jpeg")],
      ruleForm: {
        name: "",
        password: "",
        repeatPassword: "",
        phone: "",
        type: "",
        isBookStoreMember: false
      },
      rules: {
        name: [{ validator: validateName, trigger: "blur" }],
        password: [{ validator: validatePassword, trigger: "blur" }],
        repeatPassword: [
          { validator: validateRepeatPassword, trigger: "blur" },
        ],
        phone: [{ validator: validatePhone, trigger: "blur" }],
        type: [
            { required: true, message: '请选择用户类型', trigger: 'change' }
          ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(() => {
        axios
          .post("/api/regist", {
            name: this.ruleForm.name,
            password: this.ruleForm.password,
            phone: this.ruleForm.phone,
          })
          .then((res) => {
            if (res.data.result) {
              this.$router.push("/home");
            } else {
              this.$message.error("注册失败!");
            }
          });
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    goBack() {
      this.$router.go(-1);
    },
  },
};
</script>
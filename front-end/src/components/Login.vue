<template>
  <el-row>
    <el-col :span="24">
      <el-page-header @back="goBack" content="登陆"></el-page-header>
    </el-col>
    <el-col :span="10" :offset="7">
      <el-card class="box-card" shadow="always">
        <!--<div id="header">
          <el-col :span="24">
            <el-page-header @back="goBack" content="登陆"></el-page-header>
          </el-col>
        </div>
        <el-col :span="16">
          <el-carousel style="margin-bottom:20px;">
            <el-carousel-item v-for="img in imgs" :key="img">
              <img style="width:100%" :src="img" />
            </el-carousel-item>
          </el-carousel>
          <img :src="img" style="width:100%; margin-bottom:20px;" />
        </el-col>-->
        <div style="text-align: center">
          <p style="font-family:'Hiragino Sans GB';font-size: $--font-size-large">登陆</p>
        </div>
        <el-divider></el-divider>
        <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-width="60px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="name">
            <el-input type="text" v-model="ruleForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">登陆</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
            <div style="float:right">
              <el-button type="success" @click="jump()">注册</el-button>
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
  name: "Login",
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
    return {
      imgs: [require('../assets/004.jpeg'), require('../assets/002.jpeg')],
      ruleForm: {
        name: "",
        password: "",
      },
      rules: {
        name: [{ validator: validateName, trigger: "blur" }],
        password: [{ validator: validatePassword, trigger: "blur" }],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(() => {
        axios
          .post("/api/login", { name: this.ruleForm.name, password: this.ruleForm.password })
          .then((res) => {
            if (res.data.result) {
              this.$router.push("/home")
            } else {
              this.$message.error('用户名或密码错误!')
            }
          });
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    jump() {
      this.$router.push("/join")
    },
    goBack() {
        this.$router.go(-1)
      }
  },
};
</script>

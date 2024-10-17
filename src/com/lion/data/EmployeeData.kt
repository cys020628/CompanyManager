package com.lion.data

import java.io.Serializable

// 직원 종류를 관리하는 클래스
data class EmployeeTypeData(
    val employeeType: String // 부서 종류
) : Serializable

// 직원 정보를 관리하는 클래스
data class EmployeeData(
    val employeeName: String, // 이름
    val employeeAge: Int, // 나이
    val employeeRank: String, // 직급
    val employeeType: EmployeeTypeData // 부서 종류
) : Serializable

// 객체의 직렬화를 위해 Serializable 인터페이스 구현






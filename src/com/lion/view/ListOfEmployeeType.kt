package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.ProgramState
import java.util.Scanner

class ListOfEmployeeType(val controller: Controller) : ViewClass() {
    override fun show() {
        print("직원 목록을 조회하실 부서를 입력해주세요 : ")
        // 부서를 입력받는다.
        val inputType = inputEmployeeType()
        showListOfEmployee(inputType)

        // 화면 상태를 메인메뉴로 변경
        controller.programState = ProgramState.STATE_SHOW_MAIN_MENU
    }

    // 부서를 입력 받는다.
    private fun inputEmployeeType(): String {
        val scanner = Scanner(System.`in`)
        val inputType = scanner.next()
        return inputType
    }

    private fun showListOfEmployee(type: String) {
        EmployeeRepository.showListOfEmployee(type)
    }
}
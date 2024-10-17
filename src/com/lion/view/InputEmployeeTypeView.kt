package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.ProgramState
import java.util.Scanner

class InputEmployeeTypeView(val controller: Controller):ViewClass() {
    override fun show() {

        // 현재 등록된 부서들을 반환한다.
        showEmployeeType()
        // 등록할 부서를 입력 받는다.
        val inputType = InputEmployeeType()
        // 이미 등록된 부서인지 확인
        if(isDuplicateType(inputType)) {
            // 등록된 부서가 아니라면
            // 등록 진행
            addEmployeeDepartment(inputType)
            println("$inputType 부서의 등록이 성공적으로 진행되었습니다.")
        }else {
            // 이미 등록된 부서라면
            println("이미 등록된 부서 입니다.")
        }

        // 화면 상태를 메인메뉴로 변경
        controller.programState = ProgramState.STATE_SHOW_MAIN_MENU
    }

    // 등록할 부서이름을 입력
    private fun InputEmployeeType(): String {
        println()
        println("등록하실 부서를 입력해주세요")
        print("부서 : ")
        val scanner = Scanner(System.`in`)
        val inputType = scanner.next()
        return inputType
    }

    // 현재 등록된 부서를 반환하는 함수
    private fun showEmployeeType() {
        println("현재 등록된 부서 ${EmployeeRepository.getAllEmployeeType()}")
    }

    // 이미 등록한 부서인지 확인
    private fun isDuplicateType(inputType:String):Boolean {
        return EmployeeRepository.checkDepartmentIsDuplication(inputType)
    }

    // 부서 등록
    private fun addEmployeeDepartment(inputType:String) {
        EmployeeRepository.addEmployeeDepartment(inputType)
    }
}
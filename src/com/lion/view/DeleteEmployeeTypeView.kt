package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.ProgramState
import java.util.*

class DeleteEmployeeTypeView(val controller: Controller):ViewClass() {
    override fun show() {
        // 등록된 부서가 있는지 확인
        if(checkIsExistDepartment()) {
            // 등록된 부서가 있다면 부서를 입력 받는다.
            showEmployeeType()
            val inputType = inputDeleteEmployeeType()
            // 부서를 삭제한다.
            deleteEmployeeType(inputType)

        }else {
            // 등록된 부서가 없다면
            println("등록된 부서가 없습니다. 먼저 부서를 등록해주세요.")
        }
        // 화면 상태를 메인메뉴로 변경
        controller.programState = ProgramState.STATE_SHOW_MAIN_MENU
    }

    // 등록되어 있는 부서가 있는지 확인
    private fun checkIsExistDepartment():Boolean {
        return EmployeeRepository.getAllEmployeeType().isNotEmpty()
    }

    // 현재 등록된 부서를 반환하는 함수
    private fun showEmployeeType() {
        println("현재 등록된 부서 ${EmployeeRepository.getAllEmployeeType()}")
    }

    // 삭제할 부서를 입력받는 기능
    private fun inputDeleteEmployeeType(): String {
        val scanner = Scanner(System.`in`)
        print("삭제할 부서를 입력해주세요 : ")
        val inputName = scanner.next()
        return inputName
    }

    // 부서를 삭제한다.
    private fun deleteEmployeeType(inputType:String) {
        EmployeeRepository.deleteEmployeeType(inputType)
    }
}
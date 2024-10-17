package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.ProgramState

class ShowAllEmployeeInfoView(val controller: Controller) : ViewClass() {
    override fun show() {

        // 현재 등록되어있는 부서가 있는지 확인한다.
        if (checkIsExistDepartment()) {
            // 등록되어 있는 부서가 있다면
            // 전체 등록된 직원의 정보를 보여준다.
            showAllEmployeeInfo()
        } else {
            // 등록되어 있는 부서가 없다면
            println("현재 등록되어있는 부서가 없습니다.")
        }

        // 화면 상태를 메인메뉴로 변경
        controller.programState = ProgramState.STATE_SHOW_MAIN_MENU
    }

    // 현재 등록되어있는 부서가 있는지 확인
    private fun checkIsExistDepartment(): Boolean {
        return EmployeeRepository.getAllEmployeeType().isNotEmpty()
    }

    // 전체 등롣된 직원의 정보를 보여주는 함수
    private fun showAllEmployeeInfo() {
        EmployeeRepository.showAllEmployeeInfo()
    }
}
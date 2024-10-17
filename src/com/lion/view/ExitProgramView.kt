package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.Util
import kotlin.system.exitProcess

class ExitProgramView(val controller: Controller) : ViewClass() {
    override fun show() {
        // 종료하기전 데이터를 저장한다.
        saveData()
        // 프로그램을 종료한다.
        exitProgram()
    }

    private fun exitProgram() {
        exitProcess(0)
    }

    private fun saveData() {
        Util.saveData(EmployeeRepository.getEmployeeList(), EmployeeRepository.getEmployeeTypeList())
    }
}
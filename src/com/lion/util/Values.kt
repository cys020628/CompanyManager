package com.lion.util

class Values {
    companion object {
        // 파일 이름
        val fileName = "employeeList.dat"
    }
}

enum class ProgramState(var number:Int, var str:String) {
    // 메인메뉴
    STATE_SHOW_MAIN_MENU(1,"메인메뉴"),
    // 부서 추가
    STATE_INPUT_TYPE(2,"부서 추가"),
    // 부서 삭제
    STATE_DELETE_TYPE(3,"부서 삭제"),
    // 직원 정보 입력
    STATE_INPUT_EMPLOYEE_INFO(4,"직원 정보 입력"),
    // 전체 직원 정보 조회
    STATE_SHOW_ALL_EMPLOYEE_INFO(5, "전체 직원 정보 조회"),
    // 직원 이름 검색
    STATE_SEARCH_EMPLOYEE_INFO(6,"직원 이름 검색"),
    // 직원 정보 삭제
    STATE_DELETE_EMPLOYEE_INFO(7, "직원 정보 삭제"),
    // 부서별 직원 목록 조회
    STATE_LIST_OF_EMPLOYEE_TYPE(8,"부서별 직원 목록 조회"),
    // 프로그램 종료
    STATE_EXIT_PROGRAM(9, "프로그램 종료")
}

// 메인메뉴 번호
enum class MainMenuNumber(var number:Int, var str:String) {

    // 부서 추가
    MAIN_MENU_INPUT_TYPE(1,"부서 추가"),
    // 부서 삭제
    MAIN_MENU_DELETE_TYPE(2,"부서 삭제"),
    // 직원 정보 입력
    MAIN_MENU_INPUT_EMPLOYEE_INFO(3,"직원 정보 입력"),
    // 전체 직원 정보 조회
    MAIN_MENU_SHOW_ALL_EMPLOYEE_INFO(4, "전체 직원 정보 조회"),
    // 직원 이름 검색
    MAIN_MENU_SEARCH_EMPLOYEE_INFO(5,"직원 이름 검색"),
    // 직원 정보 삭제
    MAIN_MENU_DELETE_EMPLOYEE_INFO(6, "직원 정보 삭제"),
    // 부서별 직원 목록 조회
    STATE_LIST_OF_EMPLOYEE_TYPE(7,"부서별 직원 목록 조회"),
    // 프로그램 종료
    MAIN_MENU_EXIT_PROGRAM(8, "프로그램 종료")
}
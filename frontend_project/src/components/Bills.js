import React, { useEffect, useState } from 'react'
import axios from 'axios'
import ShowTimeTable from './ShowTimeTable';
/*
  This component is used for rendering the "Bills" view which contains each Bill of the Student
  Each Bill is its own component
  
  bills: Collection of bills of the given Student
  payBill: Method that uses the axios service to pay the specified bill, i.e. send a DELETE request
*/  
const Bills = ({userData}) => {  
  console.log(userData);
  const [timeTable, setTimeTable] = useState([
    {
      "capacity": 0,
      "courseCode": "",
      "courseId": 0,
      "courseScheduleList": [
          {
              "building": "",
              "day": "",
              "id": 0,
              "room": "",
              "time": ""
          },
          {
              "building": "",
              "day": "",
              "id": 0,
              "room": "",
              "time": ""
          }
      ],
      "credits": 0,
      "description": "",
      "facultyName": "",
      "name": "",
      "studentList": [],
      "term": 0,
      "year": 0
  }
]);


  useEffect(()=> {
    const getTimeTable = async (userObject) => {
      const billsUrl = `http://localhost:8080/esd_project-1.0-SNAPSHOT/api/student/fetchCourseAndTimeTable`
      const response = await axios.post(`${billsUrl}?student_id=${userObject.studentId}`)
      console.log(response.data);
      return response.data
    }
    getTimeTable(userData).then((value)=> {
      setTimeTable(value);
    })
  }, []);


  // const [timetable, setTimeTable] = useState([
  //     {
  //       "capacity": 0,
  //       "courseCode": "",
  //       "courseId": 0,
  //       "courseScheduleList": [
  //           {
  //               "building": "",
  //               "day": "",
  //               "id": 0,
  //               "room": "",
  //               "time": ""
  //           },
  //           {
  //               "building": "",
  //               "day": "",
  //               "id": 0,
  //               "room": "",
  //               "time": ""
  //           }
  //       ],
  //       "credits": 0,
  //       "description": "",
  //       "facultyName": "",
  //       "name": "",
  //       "studentList": [],
  //       "term": 0,
  //       "year": 0
  //   }
  // ]);


  return (
    <ShowTimeTable data={timeTable} />
  )

}

export default Bills
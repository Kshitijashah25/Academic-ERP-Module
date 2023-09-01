import axios from 'axios'

// The API endpoint where bills are located
const billsUrl = `http://localhost:8080/esd_project-1.0-SNAPSHOT/api/student/fetchCourseAndTimeTable`

// Gets all bills which belong to a user
const getUserBills = async (student) => {
  // Get bills of the given user, using query parameter, ?user={user.studentId}
  const response = await axios.post(`${billsUrl}?student_id=${student.studentId}`,this.state)
  
  // The .data field would now contain the bills of the users
  return response.data
}

// Pays the bill which is specified, after paying, the record of the bill is deleted
// So this translates to a delete request from axios to the bill API endpoint at the backend
// const payBill = async (bill) => {
//   const response = await axios.delete(`${billsUrl}/${bill.billId}`)
//   return response.data
// }

const exportObject = { getUserBills }

export default exportObject
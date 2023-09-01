import React from 'react'

const TimeTableData = ({data}) => {

    console.log(data);
    return (
        data.courseScheduleList.map(cs => 
            <tr>
                <td>{data.courseCode}</td>
                <td>{data.name}</td>
                <td>{data.facultyName}</td>
                <td>{cs.time}</td>
                <td>{cs.day}</td>
                <td>{cs.room}</td>
                <td>{cs.building}</td>
            </tr>
        )
    )
}

export default TimeTableData
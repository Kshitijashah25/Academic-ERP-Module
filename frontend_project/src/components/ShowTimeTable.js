import TimeTableData from "./TimeTableData";
import React from "react";
const ShowTimeTable = ({data}) => {


    if(data === []) {
        return null;
    }

    console.log(data[0].courseScheduleList[0].building);
    return (
        <div className='m-5 p-2 rounded regular-shadow' id="bills">
          <h2 className='ml-2'>Time Table</h2>
          <table className="table" cellPadding={10}>
            <tr>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Faculty Name</th>
                <th>Time</th>
                <th>Day</th>
                <th>Room Number</th>
                <th>Building</th>
            </tr>
        
            { 
              data.map(d => 
                <TimeTableData data={d} key={d.courseId}/>)
            }        
            </table>
        </div>
        )
}

export default ShowTimeTable
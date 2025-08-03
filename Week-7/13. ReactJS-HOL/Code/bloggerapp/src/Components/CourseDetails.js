export const courses = [
  {name:'Angular', date:'4/5/2021'},
  {name:'React', date:'6/3/20201'}
];

const CourseDetails=(props)=>{
  const coursedet=(
    <div>
      {props.courses.map((course)=>(
        <div key={course.name}>
          <h2>{course.name}</h2>
          <h4>{course.date}</h4>
        </div>
      ))}
    </div>
  )
  
  return coursedet;
};

export default CourseDetails;
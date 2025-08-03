import './Styles.css';
import './App.css';
import CourseDetails from './Components/CourseDetails';
import BlogDetails from './Components/BlogDetails';
import BookDetails from './Components/BookDetails';
import { books } from './Components/BookDetails';
import { blogContent } from './Components/BlogDetails';
import { courses } from './Components/CourseDetails';

const App = () => {
  return (
    <div className="app-container">
      <div className="main-content">
        <div className="mystyle1">
          <h1>Course Details</h1>
          <CourseDetails courses={courses} />
        </div>
        
        <div className="green-separator"></div>
        
        <div className="st2">
          <h1>Book Details</h1>
          <BookDetails books={books} />
        </div>
        
        <div className="green-separator"></div>
        
        <div className="v1">
          <h1>Blog Details</h1>
          <BlogDetails content={blogContent} />
        </div>
      </div>
    </div>
  );
};

export default App;
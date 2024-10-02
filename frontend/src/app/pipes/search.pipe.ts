import { Pipe, PipeTransform } from '@angular/core';
import { Blog } from '../interfaces/blog';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(blogs: Blog[], searchKey:string): Blog[] {
    return blogs.filter((blog)=> blog.title.toLowerCase().includes(searchKey.toLowerCase()));
  }
}

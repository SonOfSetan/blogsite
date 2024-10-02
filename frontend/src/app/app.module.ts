import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { SearchPipe } from './pipes/search.pipe';
import { NotFoundComponent } from './shared/not-found/not-found.component';
import { AllblogsComponent } from './components/allblogs/allblogs.component';
import { BlogItemComponent } from './components/blog-item/blog-item.component';
import { ErrorsComponent } from './shared/errors/errors.component';
import { PaginatorComponent } from './components/paginator/paginator.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { HttpInterceptorInterceptor } from './shared/http-interceptor.interceptor';
import { LoaderComponent } from './shared/loader/loader.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SearchPipe,
    NotFoundComponent,
    AllblogsComponent,
    BlogItemComponent,
    LoaderComponent,
    ErrorsComponent,
    PaginatorComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CardModule,
    ButtonModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatProgressSpinnerModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

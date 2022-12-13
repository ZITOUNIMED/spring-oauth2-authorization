import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ArticlesComponent } from "./articles/articles.component";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { MessagesComponent } from "./messages/messages.component";

const routes: Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'messages', component: MessagesComponent},
    {path: 'articles', component: ArticlesComponent},
    {path: 'login', component: LoginComponent},
    {path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, {
            enableTracing: true,
            useHash: true
        })
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {

}
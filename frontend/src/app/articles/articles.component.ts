import { Component, OnInit } from '@angular/core';
import { Article } from '../models/article.model';
import { ArticlesService } from '../services/articles.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  publicArticles: Article[] = [];
  articles: Article[] = [];
  constructor(private articlesService: ArticlesService) { }

  ngOnInit(): void {
    this.articlesService.getPublicArticles()
    .subscribe(res => {
      this.publicArticles = res;
    });

    this.articlesService.getArticles()
    .subscribe(res => {
      this.articles = res;
    });
  }

}

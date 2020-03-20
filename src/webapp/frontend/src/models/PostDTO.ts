/* eslint-disable */
export class PostDTO {
  public id?: string;
  public img?: string;
  public title?: string;
  public content?: string;
  public timeCreated?: string;
  public author?: string;

  constructor(init?: Partial<PostDTO>) {
    Object.assign(this, init);
  }
}

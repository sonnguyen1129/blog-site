/* eslint-disable */
export class UserProfileDTO {
  public username?: string;
  public email?: string;

  constructor(init?: Partial<UserProfileDTO>) {
    Object.assign(this, init);
  }
}
